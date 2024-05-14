import {
    InputOTP,
    InputOTPGroup,
    InputOTPSlot,
} from "@/components/ui/input-otp"
import { REGEXP_ONLY_DIGITS } from "input-otp"


function PortInput({ value, handleChange }) {
    return (
        <InputOTP maxLength={4} pattern={REGEXP_ONLY_DIGITS} value={value} onChange={(value) => handleChange(value)}>
            <InputOTPGroup>
                <InputOTPSlot index={0} />
                <InputOTPSlot index={1} />
                <InputOTPSlot index={2} />
                <InputOTPSlot index={3} />
            </InputOTPGroup>
        </InputOTP>

    )
}

export default PortInput